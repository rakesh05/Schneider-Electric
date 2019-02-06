import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Click on \'Import\' button in \'Universal Template EU\' template'
WebUI.click(findTestObject('User Defined Import Export/btn_Actions Buttons', [('templateName') : templateName, ('buttonName') : 'Import']))

'Validate the saved template name'
WebUI.verifyElementAttributeValue(findTestObject('User Defined Import Export/input_Template Name'), 'value', templateName, 
    10)

'Wait for 10 sec'
WebUI.delay(GlobalVariable.G_Timeout)

'upload file from selected file path'
CustomKeywords.'com.robotclass.FileUpload.fileUpload'(findTestObject('User Defined Import Export/btn_Add Button'), uploadFilePath)

'Wait for 10 sec'
WebUI.delay(GlobalVariable.G_Timeout)

'Click on Upload button'
WebUI.click(findTestObject('User Defined Import Export/btn_Upload Button'))

'Wait for upload button to disappear'
WebUI.waitForElementNotPresent(findTestObject('User Defined Import Export/btn_Upload Button'), GlobalVariable.G_Timeout)

'Validate the file upload message.'
WebUI.verifyElementText(findTestObject('User Defined Import Export/txt_Import Message', [('msg') : 'sMsg']), fileUploadMsg)

'Click on Start Process'
WebUI.click(findTestObject('User Defined Import Export/btn_Start Process'))

'Wait for 10 sec'
WebUI.delay(GlobalVariable.G_Timeout)

'Validate the upload process message'
WebUI.verifyElementText(findTestObject('User Defined Import Export/txt_Import Message', [('msg') : 'processMsgId2']), startProcessMsg)

