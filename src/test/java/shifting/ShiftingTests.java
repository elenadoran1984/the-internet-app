package shifting;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.ShiftingContentPage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShiftingTests extends BaseTests {
    @Test
    public void testShifting() {
       ShiftingContentPage shiftingContentPage =  homePage.clickShiftingContent();
       MenuPage menuPage = shiftingContentPage.clickMenuElement();
        List<String> expectedNames = Arrays.asList(
                "Home", "About", "Contact Us", "Portfolio", "Gallery"
        );
        assertEquals(menuPage.returnSizeElements(), 5, "Invalid size");
        assertEquals(menuPage.returnNameElements(), expectedNames, "Invalid names");
    }

}
