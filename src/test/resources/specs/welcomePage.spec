@objects
  sign-in         id      customerSignIn__wrapper
  cust_title      xpath   .//*[@class='customerSignIn__title']
  cust-signin     css   .customerSignIn__buttonWrapper
  save-time       css   .customerSignIn__copy


= Welcome Page =

   @on android
     sign-in:
         height 500px
         
   @on mobile
     sign-in:
      height 200px
      
     cust-signin:
      below cust_title 10 to 20px
      
   @on desktop
      sign-in:
         height 126px
         
      cust-signin:
         below cust_title 22 to 30px
         
      cust_title:
         text is "Already a customer with a BMO Debit Card?"
         text starts "already"
         text contains "failing test"
         