import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

String nama = 'Fetty'

String surel = 'fetty@sv.it'

ResponseObject response = WS.sendRequest((RequestObject) findTestObject('CreateUser', [('nama') : nama, ('surel') : surel]))

WS.verifyResponseStatusCode(response, 201)

WS.comment('Got response:\n' + response.getResponseBodyContent())

WS.verifyElementPropertyValue(response, 'nama', nama)

WS.verifyElementPropertyValue(response, 'surel', surel)

GlobalVariable.id = WS.getElementPropertyValue(response, 'id')

