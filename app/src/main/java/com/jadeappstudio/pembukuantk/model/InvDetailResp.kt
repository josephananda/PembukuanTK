/*
 * Created by Joseph Ananda Sugihdharma on 12/11/20 11:41 PM .
 * Copyright (c) 2020 . All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jadeappstudio.pembukuantk.model

object InvDetailResp {
    data class InvoiceDetail(
        var id: Int? = 0,
        var customer_name: String? = "",
        var customer_phone: String? = "",
        var customer_email: String? = "",
        var customer_address: String? = "",
        var total_invoice_price: String? = "",
        var created_at: String? = "",
        var updated_at: String? = "",
        var products: List<ItemInvoice>
    )
}