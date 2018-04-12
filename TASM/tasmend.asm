.model small
.stack
.data

  uMaxLength db 255
  uActualLength db ?
  szFileName db 255 dup (?)
  buffer db 100 dup (?), '$'
  vowels db "aeiou"

  num_words db 00h
  num_lines db 00h
  num_vowels db 00h

  OpenFileErrorMessage db 'No such file.','$'
  ReadErrorMessage db 'Cannot read from file.','$'
  InputMessage db 'Write a filename and the program will display it:', '$'


  msg_vowels db 10,13,"Vowels : $"
  msg_words db 10,13,"Words : $"
  msg_lines db 10,13,"Lines : $"

PRINT MACRO MSG
  mov ah,09h
  lea dx,MSG
  int 21h
ENDM

.code
main   proc

  mov ax, seg uMaxLength 
  mov ds, ax

  mov ah, 09h
  lea dx, InputMessage 
  int 21h


  mov ah, 0ah
  lea dx, uMaxLength 
  int 21h

  mov al, uActualLength 
  xor ah, ah
  mov si, ax
  mov szFileName[si], 0 

  mov ah, 3dh
  xor al, al 
  lea dx, szFileName
  int 21h 

  jc openError 

  mov bx, ax 

  repeat:

  mov ah, 3fh
    lea dx, buffer
    mov cx, 100 
    int 21h

    jc readError

    mov si, ax
    mov buffer[si], '$'

    call new_line
    mov ah, 09h
    int 21h 

 

    cmp si, 100
    je repeat 

    call new_line
    ; PRINT msg_vowels
    
    call lines
    
    PRINT msg_lines
    mov bl , num_lines
    call printnum
    
    PRINT msg_words
    mov bl , num_words
    call printnum

    PRINT msg_vowels
    mov bl , num_vowels
    call printnum


    jmp stop



  openError:

    call new_line
    PRINT OpenFileErrorMessage
    jmp stop

 
  readError:

  call new_line
   PRINT ReadErrorMessage
  stop:

    mov ax, 4c00h
    int 21h



new_line proc near
  
  push dx
  push ax
  mov dl,0ah
  mov ah,02h
  int 21h
  pop ax
  pop dx
  ret
new_line endp

; prints the value in bx
printnum proc near
  push cx
  mov cx, 0404h

  l3:
    dec ch
    rol bx,cl
    mov dl,bl
    and dl,0fh
    cmp dl,09h
    jbe add_30
    add dl,07h
    add_30: add dl,30h
    mov ah,02h
    int 21h
    cmp ch,00h
    jg l3
    
  pop cx

  ret
printnum endp

lines proc near
  
  push ax
  push bx

  mov cx,si

  xor ax,ax
  xor bx,bx
  ; al lines
  ; ah words
  ; bl vowels

  mov si,0
  l1:
    
    call chk_newline
    call chk_vowel
    call chk_word
    ; cmp buffer[si],0 ; null char to check end of string
    ; jne continue
    ; je stp3
    
    ; continue:
      inc si
    loop l1

    inc al ; last line is not counted yet, so this includes it
    mov num_lines,al
    mov num_words,ah
    mov num_vowels,bl
    pop bx
    pop ax
    ret
lines endp

chk_word proc near
  cmp buffer[si],32
  jne stp1
  inc ah
  stp1:
    ret
chk_word endp


chk_newline proc near
  cmp buffer[si],10
  jne stp ; stop label
  inc al ; inc al as new line is found
  stp:
    ret
chk_newline endp

chk_vowel proc near
  
  push cx
  push ax
  mov cx,05h
  mov di, 0
  l2: 
    mov ah,vowels[di]
    mov al,buffer[si]
    cmp al,ah 
    jne isnotVowel
    inc bl
    isnotVowel: 
        inc di
    loop l2
    
  pop ax
  pop cx
  ret
chk_vowel endp

main   endp




end main



END
