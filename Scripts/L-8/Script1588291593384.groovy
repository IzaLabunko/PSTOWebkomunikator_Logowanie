import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

// Sprawdza, czy użytkownik może się zalogować wpisując tylko poprawną Nazwę użytkownika

WebUI.openBrowser('')

WebUI.navigateToUrl('http://kmg.hcm.pl/testowanie/')

WebUI.maximizeWindow()

//TestObject zdefiniowany po id.

//Zmienna Login - ie wykorzystane w tym przypadku testowym

String Login = "Iza"

println(Login)

//Zmienna Haslo

String Haslo = "ilabunko"

println(Haslo)

WebUI.sendKeys(findTestObject('Nazwa użytkownika'),"")

WebUI.sendKeys(findTestObject('Hasło'), Haslo)

WebUI.click(findTestObject('Button Login'))

WebUI.verifyAlertPresent(0)

WebUI.verifyElementVisible(findTestObject('Text Link Zajestruj konto'))

WebUI.closeBrowser()

