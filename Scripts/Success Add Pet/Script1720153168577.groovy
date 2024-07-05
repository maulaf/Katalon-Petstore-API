import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable
import com.github.javafaker.Faker as Faker

Faker faker = new Faker()

name = faker.dog().name()
categoryName = faker.dog().breed()
tagsName = "test"

ResponseObject response = WS.sendRequest(findTestObject('Object Repository/addPet',
	[
		('name') : name,
		('categoryName') : categoryName,
		('tagsName') : tagsName
	]
))

WS.verifyResponseStatusCode(response, 200)

petID = WS.getElementPropertyValue(response, 'id')

println("Pet ID = $petID")

ResponseObject getResponse = WS.sendRequest(findTestObject('Object Repository/getPetById',
	[('petId') : petID]
))

WS.verifyResponseStatusCode(getResponse, 200)

WS.comment('Got response:\n' + getResponse.getResponseBodyContent())

// Convert response content to JSON object
def jsonResponse = new groovy.json.JsonSlurper().parseText(getResponse.getResponseText())

// Verify element property values
WS.verifyElementPropertyValue(getResponse, "name", name)
WS.verifyElementPropertyValue(getResponse, "category.name", categoryName)
WS.verifyElementPropertyValue(getResponse, "tags.name", [tagsName])

