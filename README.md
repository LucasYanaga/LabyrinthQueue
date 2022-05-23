# LabyrinthQueue

<p>Este trabalho tem como objetivo criar um programa capaz de enfileirar comandos para resolver um determinado labirinto.
   O programa terá um painel de comandos contendo as seguintes opções (UP, DOWN, LEFT, RIGHT, GO, RESTART) e a cada interação
   o painel e o labirintos são printados novamente.
</p><br>

<p>O programa inicia lendo um labirinto desenhado em um arquivo txt (este arquivo já deve estar formatado). Logo após a leitura, o 
programa passa o desenho para uma matriz e vai procurar por um "E" e um "S" para definir a entrada e saída do labirinto, respectivamente.</p>
<br>

<p> Iniciando a solução...</p>
<img src="https://github.com/LucasYanaga/LabyrinthStack/blob/master/img/img.png">
<br>

<p>Aqui podemos ver que o programa decidiu ir para cima por conta da ordem dos "IFs" na hora de analisar as 4 direções.
 Ele analisará as direções nessa ordem: UP, DOWN, LEFT, RIGHT. E por conta disso, ele andou para cima ao invés de ir para direita.
</p>
<img src="https://github.com/LucasYanaga/LabyrinthStack/blob/master/img/img_1.png">
<br>

<p>Aqui ele encontrou um dead end e desempilhou a coordenada.</p>
<img src="https://github.com/LucasYanaga/LabyrinthStack/blob/master/img/img_2.png">
<br>

<p>Assim sucessivamente até encontrar um caminho livre e que não tenha sido percorrido</p>
<img src="https://github.com/LucasYanaga/LabyrinthStack/blob/master/img/img_3.png">

<p>O caminho inteiro percorrido pelo programa até o "S"</p>
<img src="https://github.com/LucasYanaga/LabyrinthStack/blob/master/img/img_4.png">

<p>Após terminar, ele mostra a pilha com as coordenadas do caminho que ele tomou até a saída.</p>
<img src="https://github.com/LucasYanaga/LabyrinthStack/blob/master/img/img_5.png">
