package org.tyss.dream11;
import java.net.MalformedURLException;

import org.dream11.genericUtility.BaseClass;
import org.dream11.objectUtility.ContentOfMatchCard;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContentOfMatchCardTest extends BaseClass  {
	@Test
	public void verifyContentOfMatchCardTest()  throws MalformedURLException {
		String sheetName="dream11";
		String expectedTourName=excelUtility.getDataFromExcel(sheetName,3,1);
		String expectedTeam1Flag=excelUtility.getDataFromExcel(sheetName,1,1);
		String expectedTeam2Flag=excelUtility.getDataFromExcel(sheetName,2,1);
		String expectedTeam1Name=excelUtility.getDataFromExcel(sheetName,4,1);
		String expectedTeam2Name=excelUtility.getDataFromExcel(sheetName,5,1);
		String expectedReminder=excelUtility.getDataFromExcel(sheetName,6,1);
		androidDriverUtility.implicitlyWait(longTimeouts);
		ContentOfMatchCard contentOfMatchCard=new ContentOfMatchCard();
		String actualTeam1Flag=contentOfMatchCard.getTeam1Flag("content-desc");
		String actualTeam2Flag=contentOfMatchCard.getTeam2Flag("content-desc");

		String actualTourName=contentOfMatchCard.getTourName();
		String actualTeam1Name=contentOfMatchCard.getTeamName("Barbados Royals");
		String actualTeam2Name=contentOfMatchCard.getTeamName("Trinbago Knight Riders");

		contentOfMatchCard.clickBellIconAction();
		String actualreminder = contentOfMatchCard.getReminder();
		contentOfMatchCard.clickCrossBtnAction();
		contentOfMatchCard.clickStreamingIcon();

		Assert.assertEquals(expectedTourName, actualTourName);
		Assert.assertEquals(expectedTeam1Flag, actualTeam1Flag);
		Assert.assertEquals(expectedTeam2Flag, actualTeam2Flag);
		Assert.assertEquals(expectedTeam1Name, actualTeam1Name);
		Assert.assertEquals(expectedTeam2Name, actualTeam2Name);
		Assert.assertEquals(expectedReminder, actualreminder);

	}
}
