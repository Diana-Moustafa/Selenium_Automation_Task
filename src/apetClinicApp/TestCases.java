package apetClinicApp;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCases extends BaseSelenium {

	// Verify ON The Pet Image
	@Test
	public void testImage() {
		WebElement petImage = driver.findElement(By.cssSelector(
				"div.container-fluid:nth-child(2) div.container.xd-container div.row:nth-child(2) div.col-md-12 > img.img-responsive"));
		{
			if (petImage.isDisplayed()) {
				System.out.println("Pet Image is displayed");
				System.out.println("The image attribute is" + petImage.getAttribute("class"));
			} else {
				System.out.println("Pet Image is not displayed");
			}
		}
	}

	// Fine All The Veterinarians and List Them
	@Test
	public void listVetes() {
		WebElement veterButton = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a"));
		veterButton.click();

		List<WebElement> objVetes = driver.findElements(By.id("vets"));
		for (WebElement obkCurrentLink : objVetes) {
			String stringListVet = obkCurrentLink.getText();
			System.out.println(stringListVet);

		}

	}

	// Find all the Owners and List Them
	@Test
	public void findOwners() {
		WebElement findOwners = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a"));
		findOwners.click();

		WebElement findOwner = driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
		findOwner.click();

		List<WebElement> objLinks = driver.findElements(By.id("owners"));
		for (WebElement obkCurrentLink : objLinks) {
			String stringLinkText = obkCurrentLink.getText();
			System.out.println(stringLinkText);

		}

	}

	// Create Owner and Pet Then Assert on Them to Make sure They Created
	@Test
	public void addOwners() throws InterruptedException {
		WebElement findOwners = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a"));
		findOwners.click();

		WebElement addOwner = driver.findElement(By.xpath("/html/body/div/div/a"));
		addOwner.click();

		driver.findElement(By.id("firstName")).sendKeys("FirstName");
		driver.findElement(By.id("lastName")).sendKeys("LastName");
		driver.findElement(By.id("address")).sendKeys("Address");
		driver.findElement(By.id("city")).sendKeys("City");
		driver.findElement(By.id("telephone")).sendKeys("");

		WebElement createOwner = driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button"));
		createOwner.click();

		List<WebElement> objOwnerName = driver.findElements(By.xpath("//tbody/tr[1]/td[1]"));
		for (WebElement obkCurrentLink : objOwnerName) {
			String stringLinkText = obkCurrentLink.getText();
			System.out.println(stringLinkText);
			assertEquals(stringLinkText, "createe twoo");

			List<WebElement> objOwnerAddress = driver.findElements(By.xpath("//tbody/tr[1]/td[2]"));
			for (WebElement obkCurrentAddress : objOwnerAddress) {
				String stringAddressText = obkCurrentAddress.getText();
				System.out.println(stringAddressText);
				assertEquals(stringLinkText, "three");

				List<WebElement> objOwnerCity = driver.findElements(By.xpath("//tbody/tr[1]/td[3]"));
				for (WebElement obkCurrentCity : objOwnerCity) {
					String stringCityText = obkCurrentCity.getText();
					System.out.println(stringCityText);
					assertEquals(stringLinkText, "four");

					List<WebElement> objOwnerPhone = driver.findElements(By.xpath("//tbody/tr[1]/td[4]"));
					for (WebElement obkCurrentPhone : objOwnerPhone) {
						String phoneNumber = obkCurrentPhone.getText();
						System.out.println(phoneNumber);
						assertEquals(phoneNumber, "4444");

						Thread.sleep(3000);

						WebElement addPet = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/a[2]"));
						addPet.click();

						driver.findElement(By.id("name")).sendKeys("bb");
						driver.findElement(By.id("birthDate")).sendKeys("2022-09-01");
						WebElement petType = driver.findElement(By.id("type"));
						Select select = new Select(petType);
						select.selectByIndex(3);

						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[2]/div[1]/button[1]"))
								.click();

						List<WebElement> objPetName = driver.findElements(
								By.xpath("/html[1]/body[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[1]/dl[1]/dd[1]"));
						for (WebElement obkCurrentPet : objPetName) {
							String stringPetText = obkCurrentPet.getText();
							System.out.println(stringPetText);
							assertEquals(stringPetText, "bb");

							List<WebElement> objPets = driver.findElements(By
									.xpath("/html[1]/body[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[1]/dl[1]/dd[2]"));
							for (WebElement obkCurrentBirth : objPets) {
								String stringBirthText = obkCurrentBirth.getText();
								System.out.println(stringBirthText);
								assertEquals(stringBirthText, "bb");
							}
						}
					}
				}
			}
		}
	}

}
