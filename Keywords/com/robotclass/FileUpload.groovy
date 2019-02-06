package com.robotclass

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import java.awt.*
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

public class FileUpload {
	@Keyword
	def fileUpload (TestObject to, String filePath) {
		WebUI.click(to)

		// Specify the file location with extension
		StringSelection ss = new StringSelection(filePath);

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// Create object of Robot class
		Robot robot = new Robot();
		Thread.sleep(5000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(5000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
