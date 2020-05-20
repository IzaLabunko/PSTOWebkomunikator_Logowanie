import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.io.ObjectStreamClass.ExceptionInfo

import javax.security.auth.login.FailedLoginException

import org.seleniumhq.jetty9.server.Authentication.Failed

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//Sprawdzam, czy użytkownik może zarejestrować konto wpisując w pola Imię i Nazwisko dowolny ciąg znaków. Wg specyfikacji nie powinien móc się zarejestrowac
WebUI.openBrowser('')

WebUI.navigateToUrl('http://kmg.hcm.pl/testowanie/')

WebUI.maximizeWindow()

//Do iterowania po bazie danych Excel wykorzystuję pętle for

for (def row = 1; row <= findTestData('InvalidNames').getRowNumbers(); row++) {
    
	WebUI.click(findTestObject('Text Link Zajestruj konto'))

    WebUI.setText(findTestObject('Rejestracja Proponowana nazwa użytkownika'), findTestData('InvalidNames').getValue('Login', 
            row))

    WebUI.setText(findTestObject('Rejestracja Haslo'), findTestData('InvalidNames').getValue('Haslo', row))

    WebUI.setText(findTestObject('Rejestracja Powtorz haslo'), findTestData('InvalidNames').getValue('Powtórz hasło', row))

    WebUI.setText(findTestObject('Rejestracja Imie'), findTestData('InvalidNames').getValue('Imię', row))

    WebUI.setText(findTestObject('Rejestracja Nazwisko'), findTestData('InvalidNames').getValue('Nazwisko', row))

    WebUI.setText(findTestObject('Kod Grupy'), findTestData('InvalidNames').getValue('Kod Grupy', row))

    WebUI.click(findTestObject('Rejestruj konto'), GlobalVariable.ValidKodGrupy)

    WebUI.verifyElementVisible(findTestObject('Rejestracja udane logowane'))

    WebUI.getText(findTestObject('Rejestracja udane logowane'))

    WebUI.click(findTestObject('Text link Powrót do logowania'))

    WebUI.setText(findTestObject('Nazwa użytkownika'), findTestData('InvalidNames').getValue('Login', row))

    WebUI.setText(findTestObject('Hasło'), findTestData('InvalidNames').getValue('Haslo', row))

    WebUI.click(findTestObject('Button Login'))

    WebUI.verifyElementPresent(findTestObject('Historia rozmów'), 0, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(findTestObject('Wyloguj'), FailureHandling.CONTINUE_ON_FAILURE)

}

WebUI.closeBrowser()

