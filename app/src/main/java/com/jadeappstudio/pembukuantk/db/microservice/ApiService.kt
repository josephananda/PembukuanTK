package com.jadeappstudio.pembukuantk.db.microservice

import com.jadeappstudio.pembukuantk.model.*
import com.jadeappstudio.pembukuantk.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST(Constants.LOGIN_URL)
    fun loginUser(@Body info: LoginModel): Call<LoginResponseModel>

    @POST(Constants.ADD_PRODUCT_URL)
    fun addProduct(@Header("Authorization") token: String, @Body product: ProductModel): Call<AddProductResponseModel>

    @GET(Constants.GET_PRODUCT_ADMIN_URL)
    fun getProductAdmin(@Header("Authorization") token: String): Call<ProductItemResponse>

    @GET(Constants.GET_PRODUCT_URL)
    fun getProduct(@Header("Authorization") token: String): Call<ProductItemResponse>

    @POST(Constants.ADD_PRODUCT_STOCK_ADMIN_URL)
    fun addProductStockAdmin(@Header("Authorization") token: String, @Body productStock: ProductStockModel): Call<AddProductStockResponseModel>

    @POST(Constants.ADD_PRODUCT_STOCK_URL)
    fun addProductStock(@Header("Authorization") token: String, @Body productStock: ProductStockModel): Call<AddProductStockResponseModel>

    @GET(Constants.GET_CUSTOMER_ADMIN_URL)
    fun getCustomersAdmin(@Header("Authorization") token: String): Call<CustomerItemResponse>

    @GET(Constants.GET_CUSTOMER_URL)
    fun getCustomers(@Header("Authorization") token: String): Call<CustomerItemResponse>

    @POST(Constants.ADD_CUSTOMER_URL)
    fun addCustomer(@Header("Authorization") token: String, @Body customer: CustomerModel): Call<AddCustomerResponseModel>

    @POST(Constants.ADD_INVOICE_ADMIN_URL)
    fun addInvoiceAdmin(@Header("Authorization") token: String, @Body invoice: AddInvoiceModel): Call<AddInvoiceResponseModel>

    @POST(Constants.ADD_INVOICE_URL)
    fun addInvoice(@Header("Authorization") token: String, @Body invoice: AddInvoiceModel): Call<AddInvoiceResponseModel>

    @GET(Constants.GET_INVOICE_ADMIN_URL)
    fun getInvoiceAdmin(@Header("Authorization") token: String): Call<GetInvoiceResponseModel>

    @GET(Constants.GET_INVOICE_URL)
    fun getInvoice(@Header("Authorization") token: String): Call<GetInvoiceResponseModel>

    @POST(Constants.GET_INVOICE_DETAIL_ADMIN_URL)
    fun getInvoiceDetailAdmin(@Header("Authorization") token: String, @Body invoice_id: GetInvoiceDetailModel): Call<InvoiceDetailResp>

    @POST(Constants.GET_INVOICE_DETAIL_URL)
    fun getInvoiceDetail(@Header("Authorization") token: String, @Body invoice_id:  GetInvoiceDetailModel): Call<InvoiceDetailResp>
}