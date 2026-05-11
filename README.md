## Summary

```
Project ini adalah automation testing untuk REST API Petstore
(https://petstore.swagger.io/v2) menggunakan Katalon Studio (versi 8.0.0).
```

## Tech Stack

- Framework: Katalon Studio
- Bahasa script: Groovy
- Build tool: Gradle (com.katalon.gradle-plugin)
- Library tambahan: JavaFaker (untuk generate data dummy seperti nama, breed, phone)
- Protocol: RESTful (JSON)

## Struktur Project

```
├── Object Repository/    → 20 request objects (.rs) per endpoint API
├── Test Cases/           → File .tc untuk Katalon
│   ├── 1. Positive Cases    (16 TC)
│   └── 2. Negative Cases    (10 TC)
├── Scripts/              → Implementasi Groovy untuk tiap test case
├── Profiles/default.glbl → GlobalVariable (base URL + ID)
├── Include/config/       → log.properties
└── build.gradle          → Dependency build
```

## Coverage Endpoint

**Pet:** addPet, getPetById, findPetsByStatus, findPetsByTags, updatePet,

updatePetWithForm, deletePet, uploadFile

**Store:** getInventory, placeOrder, getOrderById, deleteOrder

**User:** createUser, createUsersWithArrayInput, createUsersWithListInput,

getUserByName, loginUser, logoutUser, updateUser, deleteUser

## Skenario Test

**Positive (16 TC)** — happy path: create user, add/find/update/delete pet, place

order, login/logout, dll.

**Negative (10 TC)** — error handling: missing field (405), invalid status,

non-existent ID, unauthorized access, wrong credentials, dll.

## Pola Implementasi

- Data dinamis: Faker untuk nama user/pet, breed, phone — supaya tiap run

datanya unik.

- Chaining test: [GlobalVariable.id](http://GlobalVariable.id) dipakai untuk passing ID antar test case (mis.

ID user dari createUser dipakai di getUserByName/updateUser).

- Verification: WS.verifyResponseStatusCode + WS.verifyElementPropertyValue

untuk asersi field pada response.

- Parameterized request: variabel di Object Repository (${name}, ${username},

dll.) di-inject lewat findTestObject(..., map).
