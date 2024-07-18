import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable
import com.github.javafaker.Faker as Faker

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

username = "test"
Faker faker = new Faker()

new_firstName = faker.name().firstName().replaceAll('[^a-zA-Z0-9]', '')
new_lastName = faker.name().lastName().replaceAll('[^a-zA-Z0-9]', '')
new_username = new_firstName + new_lastName
new_email = new_username + "@mail.com"
new_phone = faker.phoneNumber().cellPhone()
new_password = "P@ssw0rd123"

println("first name = $new_firstName")

// update user
ResponseObject response = WS.sendRequest(findTestObject('Object Repository/updateUser',
	[
		('username') : username,
		('firstName') : new_firstName,
		('lastName') : new_lastName,
		('email') : new_email,
		('phone') : new_phone,
		('password') : new_password
	]
))

WS.verifyResponseStatusCode(response, 400)