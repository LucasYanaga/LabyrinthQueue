# LabyrinthQueue

<p>Este trabalho tem como objetivo criar um programa capaz de enfileirar comandos para resolver um determinado labirinto.
   O programa terá um painel de comandos contendo as seguintes opções (UP, DOWN, LEFT, RIGHT, GO, RESTART) e a cada interação
   o painel e o labirintos são printados novamente.
</p><br>

<p>O programa inicia lendo um labirinto desenhado em um arquivo txt (este arquivo já deve estar formatado). Logo após a leitura, o 
programa passa o desenho para uma matriz e vai procurar por um "E" e um "S" para definir a entrada e saída do labirinto, respectivamente.</p>
<br>

<p> Iniciando a solução...</p>
<img src="https://github.com/LucasYanaga/LabyrinthQueue/blob/master/images/img1.PNG">
<br>

<p>Aqui temos a primeira ação, onde o usuário escolheu o movimento "D"(Down), assim o comando foi enfileirado e em seguida,
   o labirinto foi printado. 
</p>
<img src="https://github.com/LucasYanaga/LabyrinthQueue/blob/master/images/img2.PNG">
<br>

<p>Caso o usuário tente um movimento errado, ele apenas irá printar o labirinto e painel novamente com a mensagem de movimento inválido.</p>
<img src="https://github.com/LucasYanaga/LabyrinthQueue/blob/master/images/img6.PNG">
<br>

<p>Assim sucessivamente até terminar o labirinto</p>
<img src="https://github.com/LucasYanaga/LabyrinthQueue/blob/master/images/img3.PNG">

<p>Comando "GO", onde ele vai desenfileirando os comandos e printando o caminho feito representado por um "*"</p>
<img src="https://github.com/LucasYanaga/LabyrinthQueue/blob/master/images/img4.PNG">

<p>Após terminar, caso a solução esteja correta será printado "GG!" e caso contrário, "DEFEAT!". Logo em seguida será perguntado se o usuário
deseja jogar novamente. Se sim, o programa utilizara o mesmo método do comando "X"(RESET). Se não, o programa apenas finalizara. 
</p>
<img src="https://github.com/LucasYanaga/LabyrinthQueue/blob/master/images/img5.PNG">
<img src="https://github.com/LucasYanaga/LabyrinthQueue/blob/master/images/img7.PNG">


