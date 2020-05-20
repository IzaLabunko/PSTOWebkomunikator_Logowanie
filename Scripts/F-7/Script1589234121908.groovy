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

//Sprawdzam, czy użytkownik może utworzyć konto bez potwierdzenia hasła
WebUI.openBrowser('')

WebUI.navigateToUrl('http://kmg.hcm.pl/testowanie/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Text Link Zajestruj konto'))

WebUI.sendKeys(findTestObject('Rejestracja Proponowana nazwa użytkownika'), 'Klara')

WebUI.sendKeys(findTestObject('Rejestracja Haslo'), 'Lewandowska')

WebUI.sendKeys(findTestObject('Rejestracja Imie'), 'Klara')

WebUI.sendKeys(findTestObject('Rejestracja Nazwisko'), 'Lewandowska')

WebUI.sendKeys(findTestObject('Kod Grupy'), 'wsbpstogrupaVI')

WebUI.click(findTestObject('Rejestruj konto'), GlobalVariable.ValidKodGrupy)

WebUI.verifyElementPresent(findTestObject('Nie wypelniono wszystkich pol podane hasla roznia sie'), 0)

WebUI.getText(findTestObject('Nie wypełniono wszystkich pól'))

WebUI.closeBrowser()

