DATA SEGMENT
 M1 DB  'ENTER THE ORDER OF FIRST MATRIX:','$'
 M2 DB 0AH,0DH,0AH,'ENTER THE ORDER OF SECOND  MATRIX:','$'
 M3 DB 0AH,0DH,0AH,'ENTER THE ELEMENTS OF FIRST  MATRIX:',0AH,0DH,'$'  
 M4 DB 0AH,0DH,0AH,'ENTER THE ELEMENTS OF SECOND  MATRIX:',0AH,0DH,'$' 
 M5 DB 0AH,0DH,0AH,' SUM OF TWO  MATRICES: ',0AH,0DH, '$'
 M6 DB 0AH,0DH,0AH,' MATRICES CANNOT BE ADDED: ','$'
 MAT1 DB 10 DUP(0)
 MAT2 DB 10 DUP(0)
 MAT3 DB 30 DUP(0)
 ROW DB 00H
 COL DB 00H
 DATA ENDS

 MESSAGE MACRO MESS
   LEA DX,MESS
   MOV AH,09H
   INT 21H
 ENDM

 BSPCE MACRO ASC
    MOV DL,ASC
    MOV AH,06H
    INT 21H
 ENDM

 CODE SEGMENT
  ASSUME CS:CODE,DS:DATA
     START:MOV AX,DATA
           MOV DS,AX
           MESSAGE M1
           CALL READO
           MOV BX,DX
           MOV ROW,DH
           MOV COL,DL
           MESSAGE M2
           CALL READO
           CMP BX,DX
           JZ L1
           MESSAGE M6
           JMP L7
        L1:MESSAGE M3
          LEA SI,MAT1
          CALL READ1
          MESSAGE M4
          LEA SI,MAT2
          CALL READ1
          MESSAGE M5
          BSPCE 0AH
          LEA DI,MAT1
           LEA SI,MAT2
          LEA BX,MAT3
          MOV CH,ROW
      L6:MOV CL,COL
      L2:MOV DH,00H
         MOV DL,[SI]
         ADD DL,[DI]
         JNC L5
         INC DH
      L5:MOV [BX],DH
         INC BX
         MOV [BX],DL
         INC DI
         INC SI
         INC BX
         DEC CL
         JNZ L2
         DEC CH
         JZ L3
          JMP L6
      L3:  CALL DISP
     L7: MOV AH,4CH
          INT 21H


   READO PROC NEAR
   PUBLIC READO
            MOV AH,01H
            INT 21H
            MOV DH,AL
            SUB DH,30H
            BSPCE ' '
            MOV AH,01H
            INT 21H
            MOV DL,AL
            SUB DL,30H
            RET
    READO   ENDP
    
READ1 PROC NEAR
PUBLIC READ1
       BSPCE 0AH
       MOV  CH,ROW
    N2:MOV BH,COL
    N1:CALL READ
       MOV [SI],DL
       INC SI
       BSPCE ' '
       DEC BH
       JNZ N1
       DEC CH
       JZ N3
       BSPCE 0AH
       BSPCE 0DH
       JMP N2
   N3:RET
   READ1 ENDP

   READ PROC NEAR
   PUBLIC READ
MOV AH,01H
INT 21H
MOV CL,04H
MOV DL,AL
SUB DL,30H
CMP DL,0AH
JC R1
SUB DL,07H
R1:SHL DL,CL
MOV AH,01H
INT 21H
SUB AL,30H
CMP AL, 0AH
JC R2
SUB AL,07H
AND AL,0FH
R2:OR DL,AL
RET
   READ ENDP

   DISP PROC NEAR
   PUBLIC DISP
      LEA BX,MAT3
      MOV CH,ROW 
   D4:MOV DH,COL
 LOP:MOV CL,04H
    MOV DL,[BX]
     ADD DL,30H
     MOV AH,06H
     INT 21H
     INC BX
     MOV CL,04H
     MOV DL,[BX]
     SHR DL,CL
     CMP DL,0AH
     JC D1
     ADD DL,07H
   D1: ADD DL,30H
        MOV AH,06H
        INT 21H
        MOV DL,[BX]
        AND DL,0FH
        CMP DL,0AH
        JC D2
        ADD DL,07H
     D2: ADD DL,30H
        MOV AH,06H
        INT 21H
        INC BX
        BSPCE ' '
        DEC DH
        JNZ LOP
        DEC CH
        JZ D3
        BSPCE 0AH
        BSPCE 0DH
        JMP D4
        
     D3: RET
DISP ENDP
     CODE ENDS
     END START
