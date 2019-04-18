#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>

int main()
{
   char *menu = "\n1. PS \n2. Fork\n3. EXECV\n4.JOIN \n5.WAIT\n";
    printf("%s",menu);
    int option;
    scanf("%d",&option);
     int pid;
    switch(option){

       case 1:
              system("ps -A");
               break;

       case 2:
 		pid = fork();
              if(pid==0)
		printf("this is child process %d\n",getpid());
	       else	
		printf("this is parent process %d\n",getpid());
               break;
       case 3: 
		execv("./EXE",0);
               break;
      case 4: 
 		system("join file1.txt file2.txt >file4.txt");
 		break;
	case 5:
		if(fork()==0)
				printf("hello from child process");
			else{
				printf("hello from parent process");
			       system("wait");
				printf("Child process terminated");			
			}
		break;
        }



return 0;
}
