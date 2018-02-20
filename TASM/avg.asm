DATA SEGMENT
    MESS1 DB 0AH,0DH,'ENTER THE LIMIT: ''$'
     MESS2 DB 0AH,0DH,'ENTER THE NUMBER:','$'
     MESS3 DB 0AH,0DH,'AVERAGE IS : ', '$'
 DATA ENDS
NUM MACRO MESS
;MESS1 DB 05H
 ;MOV MESS1,05
 LEA DX,MESS
 MOV AH,09H
 INT 21H
 ENDM
 
   CODE SEGMENT
      ASSUME CS:CODE,DS:DATA
      START :MOV AX,DATA
                MOV DS,AX
                ;LEA DX,MESS1
                ;MOV AH,09H
                ;INT 21H
                NUM MESS1
                CALL READ
                MOV CH,DL
                MOV BH,DL
                LEA DX,MESS2
                MOV AH,09H
                INT 21H
                CALL READ
                MOV BL,DL
                MOV dh,00h
           BACK: DEC CH
                MOV DL,','
                MOV AH,06H
                INT 21H
                JZ NEXT
                CALL READ
                ADD BL,DL
                JNC LP1
                INC DH
            LP1:JMP BACK
            NEXT:MOV AL,BL
                MOV AH,DH
                     DIV BH
                 MOV BL,AL
                 MOV AL,00H
                 DIV BH
                 MOV BH,AL
                  CALL DISP
                 MOV AH,4CH
                 INT 21H


             READ PROC NEAR
             PUBLIC READ
                MOV AH,01H
                INT 21H
                MOV DL,AL
                MOV CL,04H
                SUB DL,30H
                CMP DL,0AH
                JC R1
                SUB DL,07H
             R1:SHL DL,CL
                MOV AH,01H
                INT 21H
                SUB AL,30H
                CMP AL,0AH
                JC R2
                SUB AL,07H
            R2:  AND AL,0FH
                OR DL,AL
                RET
           READ ENDP

           DISP PROC NEAR
           PUBLIC DISP
              LEA DX,MESS3
              MOV AH,09H
              INT 21H
              MOV CH,02H
            LP2:  MOV CL,04H
            MOV DL,BL
               SHR DL,CL
               CMP DL,0AH
               JC L1
               ADD DL,07H
           L1: ADD DL,30H
               MOV AH,06H
               INT 21H
               AND BL,0FH
               CMP BL,0AH
               JC L2
               ADD BL,07H
           L2: ADD BL,30H
                MOV DL,BL
                MOV AH,06H
                INT 21H
                DEC CH
                JZ NXT
                MOV DL,'.'
                MOV AH,06H
                INT 21H
                MOV BL,BH
                JMP LP2
             NXT:RET

             DISP ENDP
             CODE ENDS
             END START
