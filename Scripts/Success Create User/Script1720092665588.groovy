import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable
import com.github.javafaker.Faker as Faker

Faker faker = new Faker()


firstName = faker.name().firstName().replaceAll('[^a-zA-Z0-9]', '')
lastName = faker.name().lastName().replaceAll('[^a-zA-Z0-9]', '')
username = firstName + lastName
email = username + "@mail.com"
phone = faker.phoneNumber().cellPhone()
password = "P@ssw0rd"

ResponseObject response = WS.sendRequest(findTestObject('Object Repository/createUser',
	[
		('username') : username,
		('firstName') : firstName,
		('lastName') : lastName,
		('email') : email,
		('phone') : phone,
		('password') : password
	]
))

WS.verifyResponseStatusCode(response, 200)

// Get user by username
ResponseObject getUserResponse = WS.sendRequest(findTestObject('Object Repository/getUserByName',
	[('username') : username]
))

WS.verifyResponseStatusCode(getUserResponse, 200)

WS.comment('Got response:\n' + getUserResponse.getResponseBodyContent())

WS.verifyElementPropertyValue(getUserResponse, 'username', username)
WS.verifyElementPropertyValue(getUserResponse, 'firstName', firstName)
WS.verifyElementPropertyValue(getUserResponse, 'lastName', lastName)
WS.verifyElementPropertyValue(getUserResponse, 'email', email)
WS.verifyElementPropertyValue(getUserResponse, 'phone', phone)
WS.verifyElementPropertyValue(getUserResponse, 'password', password)

GlobalVariable.id = WS.getElementPropertyValue(getUserResponse, 'id')