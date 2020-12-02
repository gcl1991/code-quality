public class ShortSmallReview {
    private static String renderPageWithSetupsAndTeardowns(
            ShortSmall.PageData pageData, boolean isSuite
    ) throws Exception {
        if (isTestPage(pageData)) {
            includeSetupAndTeardownPages(pageData, isSuite);
        }
        return pageData.getHtml();
    }

    public static void includeSetupAndTeardownPages(ShortSmall.PageData page, boolean isSuite) {
    }


    private static boolean isTestPage(ShortSmall.PageData pageData) {
        return true;
    }
}
