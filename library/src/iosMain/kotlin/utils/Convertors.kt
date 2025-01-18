package utils

import platform.Foundation.*

fun String.toNSData(): NSData {
    return NSString.create(string = this).dataUsingEncoding(NSUTF8StringEncoding)!!
}

fun NSData.toBase64String(): String {
    return this.base64EncodedStringWithOptions(0u)
}