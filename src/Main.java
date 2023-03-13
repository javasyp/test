import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Post> posts = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== 프로그램 시작 ===");
		
		testData();
		
		int postid = 3;
		while (true) {
			System.out.print("명령어 ) ");
			String command = sc.nextLine();
			
			
			if (command.equals("post list")) {
				System.out.println("번호 |  제목");
				for (int i = posts.size() - 1; i >= 0; i--) {
					Post postlist = posts.get(i);
					System.out.println(postlist.id + "  | " + postlist.title);
				}
			} else if (command.equals("post write")) {
				int id = postid + 1;
				System.out.print("제목 : ");
				String title = sc.nextLine();
				
				System.out.print("내용 : ");
				String body = sc.nextLine();
				
				String regDate = Util.getNowDateTimeStr();
				
				posts.add(new Post(id, regDate, regDate, title, body));
				System.out.println(id + "번 글이 생성되었습니다.");
				
			} else if (command.startsWith("post detail")) {
				String[] cmd = command.split(" ");
				
				int slice = Integer.parseInt(cmd[2]);
				
				Post postlist = posts.get(slice-1);
				System.out.println("번호 : " + postlist.id);
				System.out.println("날짜 : " + postlist.regDate);
				System.out.println("제목 : " + postlist.title);
				System.out.println("내용 : " + postlist.body);
				
			} else if (command.startsWith("post modify")) {
				int index = -1;
				
				String[] cmd = command.split(" ");
				
				int slice = Integer.parseInt(cmd[2]);
				
				System.out.print("새제목 : ");
				String newtitle = sc.nextLine();
				
				System.out.print("새내용 : ");
				String newbody = sc.nextLine();
				
				String updateDate = Util.getNowDateTimeStr();
				
				
				System.out.println(slice + "번 게시물을 수정했습니다.");

			} else if (command.startsWith("post delete")) {
				String[] cmd = command.split(" ");
				
				int slice = Integer.parseInt(cmd[2]);
				
				
				for (int i=0; i < posts.size(); i++) {
					//if (slice)
				}
				
					

			}
		}
	}
	private static void testData() {
		System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");
		posts.add(new Post(1, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목1", "내용1"));
		posts.add(new Post(2, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목2", "내용2"));
		posts.add(new Post(3, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목3", "내용3"));
	}
}

class Post {
	int id;
	String regDate;
	String updateDate;
	String title;
	String body;
	
	Post(int id, String regDate, String updateDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
	}
}