data segment
    val1 dw 1111h
    val2 dw 2222h
    val3 dw 3333h
    val4 dw 4444h
    msg db "answer is:$"
data ends

code segment
    assume cs:code, ds:data
start :
    mov ax, data
    mov ds, ax

    mov dx, val1
    add dx, val3

    mov cx, val2
    adc cx, val4
    
    add dx,cx
    ;lea dx,msg
    MOV AH,9
    LEA DX,MSG
    INT 21H
    mov ah,2
    int 21h
    mov ax, 4c00h
    int 21h
code ends
    end start