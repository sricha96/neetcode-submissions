class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        createSubList(nums, res, subList, 0);

        return res;
        
    }

    public void createSubList(int[] nums, List<List<Integer>> res, List<Integer> subList, int index){

        if(index >= nums.length){
            res.add(new ArrayList<>(subList));
            return;
        }

        subList.add(nums[index]);
        createSubList(nums, res, subList, index + 1);
        subList.remove(subList.size() - 1);
        createSubList(nums, res, subList, index + 1);
    }
}
