class Main {
  public static void main(String[] args) {
    System.out.println("--------- Welcome to the Note Management Application ---------");
    System.out.println("Follow the instructions to manage your notes.");

    UserInput userInput = new UserInput();
    while (true) {
      userInput.getUserInput();
    }
  }
}