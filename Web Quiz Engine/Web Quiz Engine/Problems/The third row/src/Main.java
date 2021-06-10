class ArrayOperations {
    public static void printTheThirdRow(int[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            if (i % 3 == 2) {
                for (int j = 0; j < twoDimArray[i].length; j++) {
                    System.out.print(twoDimArray[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

//    public static void main(String[] args) throws Exception {
//        int[][] twoDimArray = {{1, 2, 3}, {4, 5}, {6}};
//        printTheThirdRow(twoDimArray);
//    }
}