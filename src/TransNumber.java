
public enum TransNumber {
	one("一"),two("二"),three("三"),four("四"),five("五"),
	six("六"),seven("七"),eight("八"),nine("九"),ten("十");
	
	private String num = null;
		
		TransNumber(String s){
			num = s;
		}
		public String toString(){
			return num;
		}
		public String getString(){
			return num;
		}
		public static TransNumber  getTransNumber(String s){
			for(TransNumber transNumber : TransNumber.values()){
				if(s.equals(transNumber.toString())) return transNumber;
			}
			return null;
		}
}
