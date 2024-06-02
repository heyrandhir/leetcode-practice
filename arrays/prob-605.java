class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0;i<flowerbed.length;i++) {
            if (flowerbed[i] == 1 ) {
                if (startIndex == -1 ) {
                    startIndex = i;
                    endIndex = i;
                } else {
                    endIndex = i;
                }
            }
        }

        if (startIndex == -1) {
            return (flowerbed.length+1)/2 >= n;
        }

        int beginPlants = (startIndex)/2;
        int endPlants = (flowerbed.length - 1 - endIndex)/2;
        int noPlantsPossible = beginPlants + endPlants;
        
        int prev = startIndex;
        for (int i = startIndex+1;i<=endIndex;i++) {
            if (flowerbed[i] == 1) {
                noPlantsPossible+= (i - prev - 2)/2;
                prev = i;
            }
        }
        return noPlantsPossible >= n;
    }
}