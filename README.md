# Ticket
## Controle de Fila Bancária

Este pequeno Sistema Web tem como finalidade o controle de senhas de atendimento de um banco ou outro serviço que tenha uma fila de atendimento para gerir o acesso.

## Finalidade do Sistema:
O sistema de Controle de Fila Bancária, CFB, comtrola a ordem de chegada dos clientes e distingue na ordem de atendimento os clientes, atendendo primerio todos os clientes preferenciais para depois começar os atendimentos Normal (sem prioridade).

## Instalação do Sistema CFB
Baixe o repositorio (git clone ...) no local desejato em seu computador, entre na pasta criada (servTicket) e use os comandos do Maven para gerar o arquivo (servTicket.war).
Depopis de subir o arquivo(servTicket.war) para o seu servidor e entrar em seu endereço no navegador ex: http://localhost:8080/servTicket/ o sistema apresenta a logomarca do CFB e passa para Tela principal de chamada de senha.

Na Tela principal de chamada de senha o gerente ou responsavel, pode acessar 2 atividades principais do sistema:

 * Tela de Geração de Senhas (nomal e Preferencial).
 * Tela de Gerenciamento de Senhas (efetua chamadas, e limpa fila).

 O acesso a essas funcionalidades deve ser dado nos respecitivos equipamentos destinados ao atendimento e o outro PC do gerente responsavel.

 Ao carregar a Tela principal de chamada de senha, tecle em:

 - Alt para Tela de Geração de Senhas.

 - Ctrl para a Tela de Gerenciamento de Senhas.


## Linguagem de programação aplicada
A linguagem de programação é o java onde emprega-se o paradigma da Orientação a Objeto que tem a sua classe no arquivo Ticket.java.

## Meios Tecnologicos utilizadas
* git
* Maven
* jdk
* Tomcat
* VS code
* github




## Regra de Negócio aplicado ao Objeto Ticket
1. O sistema deve controlar uma fila de banco com acesso a dois tipos de usuários, são eles: Normal e Preferencial.
2. O sistema deve gerar uma senha(ticket) no formato 'NXXXX' para usuario normal e 'PXXXX' para usuario Preferencial (Onde cada 'X' é um digito numérico).
3. O sistema terá que atender somente uma senha de usuario normal depois que todos os usuarios Preferenciais estiverem sido atendidos.


## Objetivos:
Estou almejando uma oportunidade no mercado de Tecnologia aqui na cidade de Florianópolis, e estou com este pequeno projeto mostrar meu trabalho, agradeço a todos que poderem de alguma forma melhorar este projeto, seja como sujestão ou se poder uma indicação que será muito bem vinda.

