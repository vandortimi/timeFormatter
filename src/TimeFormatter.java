public class TimeFormatter {

    public String formatTime(int number) {

        String finalResult = "";

        int[] timeUnits = new int[]{604800, 86400, 3600, 60, 1};
        String[] labels = new String[]{"year", "day", "hour", "minute", "second"};

        for (int i = 0; i < timeUnits.length; i++) {
            if (number >= timeUnits[i]) {
                int countWhole = number / timeUnits[i];
                number = number % timeUnits[i];
                String currentLabel = labels[i];
                finalResult += (generateResultString(number, countWhole, currentLabel, finalResult));
            }
        }

        return finalResult.equals("") ? "now" : finalResult;
    }


    private String generateResultString (int number, int countWhole, String currentLabel, String finalResult ){
        StringBuilder result = new StringBuilder();
        result
                .append(finalResult.equals("") ? "" : (number == 0 ? " and " : ", "))
                .append(countWhole)
                .append(" ")
                .append(currentLabel)
                .append(countWhole > 1 ? "s" : "");

        return result.toString();
    }

}
