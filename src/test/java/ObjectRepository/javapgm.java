package ObjectRepository;

public class javapgm {

	public static void main(String[] args) {

		/*
		 * Scanner sc=new Scanner(System.in);
		 * System.out.println("Enter the String value");
		 * 
		 * String s=sc.nextLine(); String a=s.replaceAll(" ", ""); int m=0; for(int
		 * i=a.length()-1;i>=0;i--)
		 * 
		 * { for(int j=m;j<s.length();j++) {
		 * 
		 * if(Character.isAlphabetic(s.charAt(j))) { System.out.print(a.charAt(i)); m++;
		 * break;
		 * 
		 * }
		 * 
		 * else { System.out.print(" "); m++; } } }
		 */
		int v[]= {1,2,3,1,2,4,2,3};

		for(int i=0;i<v.length-1;i++)
		{int count=0;
			
			String s=String.valueOf(v[i]);
			String s1=String.valueOf(v[i+1]);
			String r=s+s1;
			for(int j=i+1;j<v.length-1;j++)
			{
				String x=String.valueOf(v[j]);
				String x1=String.valueOf(v[j+1]);
				String y=x+x1;
				if(r.equals(y))
				{
					count++;
				}
				
			}
			System.out.println(r+" is repated"+count+" times");
		}
		
		}

}
