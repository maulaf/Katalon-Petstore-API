import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable
import com.github.javafaker.Faker as Faker

username = "test"
password = "P@ssw0rd"

ResponseObject getResponse = WS.sendRequest(findTestObject('Object Repository/loginUser', [('username') : username, ('password') : password]))

WS.verifyResponseStatusCode(getResponse, 400)

WS.comment('Got response:\n' + getResponse.getResponseBodyContent())