import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('1. Postive Cases/TC.002 - Add Pet'), [:], FailureHandling.STOP_ON_FAILURE)

Faker faker = new Faker()

name = faker.dog().name()

categoryName = faker.dog().breed()

tagsName = 'test edit'

status = "sold"

ResponseObject response = WS.sendRequest(findTestObject('Object Repository/updatePet', 
	[('name') : name, 
	('categoryName') : categoryName, 
	('tagsName') : tagsName,
	('status') : status
	]))

WS.verifyResponseStatusCode(response, 200)

WS.comment('Got response:\n' + response.getResponseBodyContent())

// Convert response content to JSON object
def jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseText())

// Verify element property values
WS.verifyElementPropertyValue(response, "name", name)
WS.verifyElementPropertyValue(response, "category.name", categoryName)
WS.verifyElementPropertyValue(response, "tags.name", [tagsName])
WS.verifyElementPropertyValue(response, "status", status)