class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, res, comb, 0);
        return res;
    }

    public void combination(int[] candidates, int target, List<List<Integer>> res, List<Integer> comb, int i){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int j = i; j < candidates.length; j++){
            if(j != i && candidates[j] == candidates[j - 1]){
                continue;
            }
            if(candidates[j] > target){
                break;
            }
            comb.add(candidates[j]);
            combination(candidates, target - candidates[j], res, comb, j + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
