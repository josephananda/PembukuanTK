package com.jadeappstudio.pembukuantk

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.AddInvoiceResponseModel
import com.jadeappstudio.pembukuantk.model.ItemListInvoice
import com.jadeappstudio.pembukuantk.model.ProductItemResponse
import com.jadeappstudio.pembukuantk.repo.InventoryRepository

class AddInvoiceViewModel : ViewModel() {
    private var inventoryRepository = InventoryRepository()
    private var itemListPlus = mutableListOf<ItemListInvoice>()
    private var itemListMinus = mutableListOf<ItemListInvoice>()
    private var itemListDistinct = mutableListOf<ItemListInvoice>()
    private var finalList = mutableListOf<ItemListInvoice>()
    private var tempArrayPlus = arrayListOf<Int>()
    private var tempArrayMinus = arrayListOf<Int>()
    private var tempUniqueFinal = arrayListOf<Int>()
    private var flag = true

    fun getProduct(context: Context): LiveData<ProductItemResponse> {
        return inventoryRepository.getProduct(context)
    }

    fun pushToList(item: ItemListInvoice) {
        if(item.qty == 1){
            itemListPlus.add(item)
        } else {
            itemListMinus.add(item)
        }
    }

    fun getProductIdArray(){
        var temp = itemListPlus.distinctBy { it.product_id }
        var tempTwo = itemListMinus.distinctBy { it.product_id }
        for(i in 0..temp.size-1){
            tempArrayPlus.add(temp[i].product_id!!)
        }
        for (j in 0..tempTwo.size-1){
            tempArrayMinus.add(temp[j].product_id!!)
        }
        checkUnique()
    }

    fun checkUnique(){
        for(i in 0..tempArrayPlus.size-1) {
            flag = true
            for (j in 0..tempArrayMinus.size - 1) {
                if (tempArrayPlus[i] == tempArrayMinus[j]) {
                    flag = false
                }
            }
            if(flag) {
                tempUniqueFinal.add(tempArrayPlus[i])
            }
            flag = true
        }
    }

    private fun checkIfExist(): MutableList<ItemListInvoice> {
        getProductIdArray()
        var tempPlus = itemListPlus.groupingBy { it.product_id }.eachCount()
        var tempMinus = itemListMinus.groupingBy { it.product_id }.eachCount()
        if(tempPlus.isNotEmpty()){
                if(tempMinus.isNotEmpty()){
                    tempPlus.forEach{ itemPlus ->
                        tempMinus.forEach{ itemMinus ->
                            if(itemPlus.key == itemMinus.key){
                                Log.i("ITEM PLUS", "$itemPlus")
                                Log.i("ITEM MINUS", "$itemMinus")
                                itemListDistinct.add(ItemListInvoice(itemPlus.key, (itemPlus.value?.minus(itemMinus.value?: 0))))
                            } else {
                                for(i in 0 until tempUniqueFinal.size){
                                    if(itemPlus.key == tempUniqueFinal[i]){
                                        itemListDistinct.add(ItemListInvoice(itemPlus.key, itemPlus.value))
                                    }
                                }
                            }
                        }
                    }
                } else {
                    tempPlus.forEach{ it ->
                        itemListDistinct.add(ItemListInvoice(it.key, it.value))
                    }
                }
        }
        Log.i("Distinct", "$itemListDistinct")
        return itemListDistinct
    }

    fun checkIfZero(): Boolean {
        val item = checkNonZero(checkIfExist())
        Log.i("itemListFinal", "$finalList")
        return item.isEmpty()
    }

    private fun checkNonZero(item: MutableList<ItemListInvoice>): MutableList<ItemListInvoice> {

        for (i in 0 until item.size) {
            if (item[i].qty!! > 0) {
                finalList.add(item[i])
            }
        }
        return finalList
    }

    fun clearList() {
        itemListPlus.clear()
        itemListMinus.clear()
        itemListDistinct.clear()
        finalList.clear()
        tempArrayPlus.clear()
        tempArrayMinus.clear()
        tempUniqueFinal.clear()
    }

    fun addInvoice(custId: Int, context: Context): MutableLiveData<AddInvoiceResponseModel> {
        return inventoryRepository.addInvoice(custId, finalList, context)
    }
}