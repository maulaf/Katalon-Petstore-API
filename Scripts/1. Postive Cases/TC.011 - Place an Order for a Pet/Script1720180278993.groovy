import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.format.DateTimeFormatter

import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable
import com.github.javafaker.Faker as Faker
import java.time.ZoneId

Faker faker = new Faker()

quantity = faker.number().digit()
status = "placed"

Date futureDate = faker.date().future(10, java.util.concurrent.TimeUnit.DAYS)

// Format the date to the required format (ISO 8601 with milliseconds and timezone Z)
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
String shipDate = futureDate.toInstant().atZone(ZoneId.of("UTC")).format(formatter)

println("quantity : $quantity")

println("shipDate : $shipDate")

println("status : $status")

ResponseObject response = WS.sendRequest(findTestObject('Object Repository/placeOrder',
	[
		('quantity') : quantity,
		('shipDate') : shipDate,
		('status') : status
	]
))

WS.verifyResponseStatusCode(response, 200)

GlobalVariable.id = WS.getElementPropertyValue(response, 'id')