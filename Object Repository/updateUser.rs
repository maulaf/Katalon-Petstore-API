<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>updateUser</name>
   <tag></tag>
   <elementGuidId>ad348df9-b35b-4a77-9533-6ac5eed9c1dc</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;id\&quot;: 0,\n  \&quot;username\&quot;: \&quot;${new_username}\&quot;,\n  \&quot;firstName\&quot;: \&quot;${new_firstName}\&quot;,\n  \&quot;lastName\&quot;: \&quot;${new_lastName}\&quot;,\n  \&quot;email\&quot;: \&quot;${new_email}\&quot;,\n  \&quot;password\&quot;: \&quot;${new_password}\&quot;,\n  \&quot;phone\&quot;: \&quot;${new_phone}\&quot;,\n  \&quot;userStatus\&quot;: 0\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-type</name>
      <type>Main</type>
      <value>application/xml</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <katalonVersion>8.0.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${GlobalVariable.url}/user/${username}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>df2498dc-0a0e-41ad-8b7b-a30745a277a3</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>db672b3e-88a2-4f9b-ad02-d3751482408e</id>
      <masked>false</masked>
      <name>new_username</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>51061e42-05c9-4a2e-84d9-56f5ceef04e4</id>
      <masked>false</masked>
      <name>new_firstName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>c2bf12bf-12eb-4517-8527-356f0457e3a7</id>
      <masked>false</masked>
      <name>new_lastName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>6a77fdcd-bdb2-4ab2-9382-32f3cd9f8fdb</id>
      <masked>false</masked>
      <name>new_email</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>b9728313-c758-4dda-b797-71225e48b38f</id>
      <masked>false</masked>
      <name>new_password</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>cb8daca3-21f5-4500-b055-7abee0e4c05e</id>
      <masked>false</masked>
      <name>new_phone</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
