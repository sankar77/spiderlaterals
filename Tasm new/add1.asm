.model small
data segment
a dw 8876h
a2 dw 1212h
b dw 8839h
b2 dw 1111h
msg db " $"
data ends

code segment
assume cs:code,ds:data
start:
mov di,2
mov dx,0
mov ax,data
mov ds,ax

addit proc near
mov ax,a
mov bx,b
add ax,bx
mov a,ax
mov ax,a2
mov bx,b2
adc ax,bx
mov a2,ax
adc dx,0

mov si,a2
l1:
mov ch,04h
mov cl,04h
mov bx,dx

l2:
rol bx,cl
mov dl,bl
and dl,0Fh
cmp dl,09
jbe l4
add dl,07

l4:
add dl,30h
mov ah,02
int 21h
dec ch
jnz l2

lea dx,msg
mov ah,9
int 21h

mov dx,si
mov si,a
dec di
jge l1

ret
addit endp

call addit 
mov ah,4ch
int 21h
code ends
end start
