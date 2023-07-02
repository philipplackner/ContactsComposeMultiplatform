package com.plcoding.contactscomposemultiplatform.contacts.domain

object ContactValidator {

    fun validateContact(contact: Contact): ValidationResult {
        var result = ValidationResult()

        if(contact.firstName.isBlank()) {
            result = result.copy(firstNameError = "The first name can't be empty.")
        }

        if(contact.lastName.isBlank()) {
            result = result.copy(lastNameError = "The last name can't be empty.")
        }

        val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
        if(!emailRegex.matches(contact.email)) {
            result = result.copy(emailError = "This is not a valid email.")
        }

        if(contact.phoneNumber.isBlank()) {
            result = result.copy(phoneNumberError = "The phone number can't be empty.")
        }

        return result
    }

    data class ValidationResult(
        val firstNameError: String? = null,
        val lastNameError: String? = null,
        val emailError: String? = null,
        val phoneNumberError: String? = null,
    )
}