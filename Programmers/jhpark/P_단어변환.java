import java.util.ArrayDeque;
import java.util.Deque;

public class P_단어변환 {

    public static void main(String[] args) {
        String begin= "hit";
        String target="cog";
        String[] words=new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin,target,words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int length=target.length();
        boolean[] visited=new boolean[words.length];
        Deque<Item> deque= new ArrayDeque<>();
        deque.add(new Item(begin,0,visited));
        while(!deque.isEmpty()){
            Item tem=deque.pop();

            if(tem.word.equals(target)){
                answer=tem.level;
                break;
            }


            for(int i=0;i<words.length;i++){
                int count=0;
                if(tem.visited[i] || words[i].equals(tem.word)){
                    continue;
                }

                for(int j=0;j<length;j++){
                    if(words[i].charAt(j)==tem.word.charAt(j) ){
                        count++;
                    }
                }
                if(count>=length-1){
                    tem.visited[i]=true;
                    deque.add(new Item(words[i],tem.level+1, tem.visited.clone()));
                    tem.visited[i]=false;
                }
            }
        }
        return answer;
    }
    static class Item{
        String word;
        int level;
        boolean[] visited;

        public Item(String word, int level,boolean[] visited) {
            this.word = word;
            this.level = level;
            this.visited = visited;
        }
    }
}
