
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassGenerator {
	public static String SYMBOL = "!#$%&*+,-.=?@^_`|~";
	public static String NUMBER = "0123456789";
	public static String LOWERCASE = "abcdefghijkmnopqrstuvwxyz";
	public static String UPPERCASE = "ABCDEFGHIJKMNOPQRSTUVWXYZ";
	public static char[] symbolarr = SYMBOL.toCharArray();
	public static char[] numberarr = NUMBER.toCharArray();
	public static char[] lowcasearr = LOWERCASE.toCharArray();
	public static char[] upcasearr = UPPERCASE.toCharArray();
	public static char[] allcharsarr;

	public static void main(String[] args) {
		int maxLength, symbols, numbers, loCaseChars, upCaseChars;
		Scanner scan = new Scanner(System.in);
		// for generating random numbers.
		Random rand = new Random();
		// for compling regular expression.
		Pattern r2;

		while (true) {
			String regexB = "";
			String allChars = "";
			String Password = "";
			System.out.print("Enter Length of password you want: ");
			maxLength = scan.nextInt();
			// strings for building the regular expression.
			String Regex_start = "(";
			String Regex_digits = "(?=.*\\d)";
			String Regex_symbols = "(?=.*[\\.\\^\\$\\*\\+\\?\\|!#%&\\-=@_~])";
			String Regex_lowercases = "(?=.*[a-z])";
			String Regex_uppercases = "(?=.*[A-Z])";
			String Regex_end = ".{6," + maxLength + "})";

			if (maxLength > 6) {// minimum length
				System.out.print("Press 1 to include Symbols: ");
				symbols = scan.nextInt();
				
				if (symbols == 1) {// checking for symbols
					allChars += SYMBOL;
					System.out.print("Press 1 to include Numbers: ");
					numbers = scan.nextInt();

					if (numbers == 1) {// checking for numbers
						allChars += NUMBER;
						System.out.print("Press 1 to include Lower Case Characters: ");
						loCaseChars = scan.nextInt();
					
						if (loCaseChars == 1) {// checking for lower case characters
							allChars += LOWERCASE;
							System.out.print("Press 1 to include Upper Case Characters: ");
							upCaseChars = scan.nextInt();
						
							if (upCaseChars == 1) {// checking for upper case characters
								allChars += UPPERCASE;
								regexB = Regex_start + Regex_digits + Regex_symbols + Regex_lowercases
										+ Regex_uppercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
									builder.append(numberarr[rand.nextInt(numberarr.length)]);
									builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
									builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							} else {
								regexB = Regex_start + Regex_digits + Regex_symbols + Regex_lowercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
									builder.append(numberarr[rand.nextInt(numberarr.length)]);
									builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							}
						} else {
							System.out.print("Press 1 to include Upper Case Characters: ");
							upCaseChars = scan.nextInt();
							if (upCaseChars == 1) {// checking for upper case characters
								allChars += UPPERCASE;
								regexB = Regex_start + Regex_digits + Regex_symbols + Regex_uppercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
									builder.append(numberarr[rand.nextInt(numberarr.length)]);
									builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							} else {
								regexB = Regex_start + Regex_digits + Regex_symbols + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
									builder.append(numberarr[rand.nextInt(numberarr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							}
						}
					} else {
						System.out.print("Press 1 to include Lower Case Characters: ");
						loCaseChars = scan.nextInt();
						if (loCaseChars == 1) {// checking for lower case characters
							allChars += LOWERCASE;
							System.out.print("Press 1 to include Upper Case Characters: ");
							upCaseChars = scan.nextInt();
							if (upCaseChars == 1) {// checking for upper case characters
								allChars += UPPERCASE;
								regexB = Regex_start + Regex_symbols + Regex_lowercases + Regex_uppercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
									builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
									builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							} else {
								regexB = Regex_start + Regex_symbols + Regex_lowercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
									builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							}
						} else {
							System.out.print("Press 1 to include Upper Case Characters: ");
							upCaseChars = scan.nextInt();
							if (upCaseChars == 1) {// checking for upper case characters
								allChars += UPPERCASE;
								regexB = Regex_start + Regex_symbols + Regex_uppercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
									builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							} else {
								regexB = Regex_start + Regex_symbols + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							}
						}
					}
				} else {
					System.out.print("Press 1 to include Numbers: ");
					numbers = scan.nextInt();
					if (numbers == 1) {// checking for numbers
						allChars += NUMBER;
						System.out.print("Press 1 to include Lower Case Characters: ");
						loCaseChars = scan.nextInt();
						if (loCaseChars == 1) {// checking for lower case characters
							allChars += LOWERCASE;
							System.out.print("Press 1 to include Upper Case Characters: ");
							upCaseChars = scan.nextInt();
							if (upCaseChars == 1) {// checking for  upper case characters
								allChars += UPPERCASE;
								regexB = Regex_start + Regex_digits + Regex_lowercases + Regex_uppercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(numberarr[rand.nextInt(numberarr.length)]);
									builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
									builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							} else {
								regexB = Regex_start + Regex_digits + Regex_lowercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(numberarr[rand.nextInt(numberarr.length)]);
									builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							}
						} else {
							System.out.print("Press 1 to include Upper Case Characters: ");
							upCaseChars = scan.nextInt();
							if (upCaseChars == 1) {// checking for upper case characters
								allChars += UPPERCASE;
								regexB = Regex_start + Regex_digits + Regex_uppercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(numberarr[rand.nextInt(numberarr.length)]);
									builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							} else {
								regexB = Regex_start + Regex_digits + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(numberarr[rand.nextInt(numberarr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							}
						}
					} else {
						System.out.print("Press 1 to include Lower Case Characters: ");
						loCaseChars = scan.nextInt();
						if (loCaseChars == 1) {// checking for lower case characters
							allChars += LOWERCASE;
							System.out.print("Press 1 to include Upper Case Characters: ");
							upCaseChars = scan.nextInt();
							if (upCaseChars == 1) {// checking for upper case characters
								allChars += UPPERCASE;
								regexB = Regex_start + Regex_lowercases + Regex_uppercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
									builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							} else {
								regexB = Regex_start + Regex_lowercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							}
						} else {
							System.out.print("Press 1 to include Upper Case Characters: ");
							upCaseChars = scan.nextInt();
							if (upCaseChars == 1) {// checking for upper case characters
								allChars += UPPERCASE;
								regexB = Regex_start + Regex_uppercases + Regex_end;
								allcharsarr = allChars.toCharArray();
								r2 = Pattern.compile(regexB);// compiling regular expression
								while (true) {// generating passwords.
									StringBuilder builder = new StringBuilder();
									builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
									for (int i = builder.length(); i < maxLength; i++) {
										builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
									}
									Password = builder.toString();
									Password = reshuffle(Password);
									Matcher m = r2.matcher(Password);// checking with regular expression
									if (m.matches()) {// break if match found else continue with loop
										break;
									}
								}
								System.out.print("Your Generated Password: " + Password);
							} else {
								System.out.println("You need Atleast One thing to Create a Password");
							}
						}
					}
				}
			} else {
				System.out.println("You should atleast choose a passwords with length more than 6 characters");
			}
			System.out.print("\nPress Any number to continue & 1 to exit: ");
			int tmp = scan.nextInt();
			if (tmp == 1) {// for exit.
				break;
			}
		}
		scan.close();
	}

	public static String reshuffle(String in) {
		List<Character> words = new ArrayList<Character>();
		StringBuilder builder = new StringBuilder(in.length());
		for (char c : in.toCharArray()) {
			words.add(c);
		}
		while (words.size() != 0) {
			int rand = (int) (Math.random() * words.size());
			builder.append(words.remove(rand));
		}
		return builder.toString();
	}
}
