class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        solve(res, comb, candidates, target, 0);
        return res;
    }

    public void solve(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int i){
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
            solve(res, comb, candidates, target - candidates[j], j + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
