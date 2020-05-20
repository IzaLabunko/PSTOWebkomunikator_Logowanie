import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.io.ObjectStreamClass.ExceptionInfo as ExceptionInfo
import javax.security.auth.login.FailedLoginException as FailedLoginException

import org.openqa.selenium.TakesScreenshot
import org.seleniumhq.jetty9.server.Authentication.Failed as Failed
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.TakeScreenshotKeyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.getCSSValueKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//Sprawdzam, czy użytkownik może zarejestrować konto wpisując w pole Hasło ciąg dowolnych znaków zawierający mniej niż 5 znaków
WebUI.openBrowser('')

WebUI.navigateToUrl('http://kmg.hcm.pl/testowanie/')

WebUI.maximizeWindow()

//Do iterowania po bazie danych Excel wykorzystuję pętle for
for (def row = 1; row <= findTestData('InvalidPass').getRowNumbers(); row++) {
    WebUI.click(findTestObject('Text Link Zajestruj konto'))

    WebUI.setText(findTestObject('Rejestracja Proponowana nazwa użytkownika'), findTestData('InvalidPass').getValue('Login', 
            row))

    WebUI.setText(findTestObject('Rejestracja Haslo'), findTestData('InvalidPass').getValue('Haslo', row))

    WebUI.setText(findTestObject('Rejestracja Powtorz haslo'), findTestData('InvalidPass').getValue('Powtórz hasło', row))

    WebUI.setText(findTestObject('Rejestracja Imie'), findTestData('InvalidPass').getValue('Imię', row))

    WebUI.setText(findTestObject('Rejestracja Nazwisko'), findTestData('InvalidPass').getValue('Nazwisko', row))

    WebUI.setText(findTestObject('Kod Grupy'), findTestData('InvalidPass').getValue('Kod Grupy', row))

    WebUI.click(findTestObject('Rejestruj konto'), GlobalVariable.ValidKodGrupy)

    WebUI.verifyElementVisible(findTestObject('Rejestracja Alert liczba znakow w hasle'))

    WebUI.getText(findTestObject('Rejestracja Alert liczba znakow w hasle'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementText(findTestObject('Rejestracja Alert liczba znakow w hasle'), 'HASŁO MUSI MIEĆ PRZYNAJMNIEJ 5 ZNAKÓW!', 
        FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)
	
}

WebUI.closeBrowser()

