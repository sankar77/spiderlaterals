.model small
.386p
.data
    n1 dd 12345678h
    n2 dd 11112222h
    res dd ?
.code
.startup
    mov eax, n1
    mov ebx, n2
    add eax, ebx
    mov res,eax
    call disp

    disp proc near
    mov ch,08h
up:
    mov eax,res
    rol eax, 04h
    mov res,eax
    and al, 0Fh
    cmp al, 0Ah
    JC d1
    add al,07h
    d1: add al,30h

    mov dl, al

    mov ah, 02h
    int 21h
    dec ch
    JNZ up

    ret
    endp disp
    mov ah,4ch
    int 21h

end
.exit

