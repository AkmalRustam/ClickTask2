package com.akmal.clicktask2.util.extension

import com.akmal.clicktask2.data.local.constant.LocalConstant.SYMBOL_DOLLAR

fun Double.formatPriceWithDollar(): String = "$this${SYMBOL_DOLLAR}"