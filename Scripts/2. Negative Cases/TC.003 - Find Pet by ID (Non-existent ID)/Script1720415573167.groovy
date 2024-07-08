import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable
import com.github.javafaker.Faker as Faker


petID = RandomStringUtils.randomNumeric(10)

ResponseObject getResponse = WS.sendRequest(findTestObject('Object Repository/getPetById',
	[('petId') : petID]
))

//verify pet not found
WS.verifyResponseStatusCode(getResponse, 404)