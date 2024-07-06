import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable
import com.github.javafaker.Faker as Faker

ResponseObject response = WS.sendRequest(findTestObject('Object Repository/logoutUser'))

WS.verifyResponseStatusCode(response, 200)