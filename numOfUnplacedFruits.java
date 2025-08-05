class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplacedFruitCount = 0;
        ArrayList<Integer> basketArray = new ArrayList<>(baskets.length);
        int size = fruits.length;
        for (int i = 0; i < size; i++) {
            basketArray.add(baskets[i]);
        }
        for (int i = 0; i < size; i++) {
            int fruit = fruits[i];
            int smallerCapacity = 0;
            for (int j = 0; j < basketArray.size(); j++) {
                smallerCapacity = basketArray.get(j);
                int capacity = basketArray.get(j);
                if(capacity >= fruit) {
                    basketArray.remove(j);
                    break;
                }
            }
            if(smallerCapacity < fruit) {
                unplacedFruitCount++;
            }
        }

        return unplacedFruitCount;
    }
}