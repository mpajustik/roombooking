class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        try{
            if(array != null && !(index < 0) && !(index> array.length-1)){
                System.out.println(array[index]*array[index]);
            } else if(index < 0 || index> array.length-1) {
                System.out.println("Exception!");
            } else {
                System.out.println("Exception!");
            }
        } catch (NullPointerException e){
            System.out.println("Exception!");
        }

    }
}