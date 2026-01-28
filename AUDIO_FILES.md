# 🎵 Arquivos de Áudio - Educar e Brincar

Este documento descreve os arquivos de áudio gerados para o aplicativo educacional **Educar e Brincar**.

## 📋 Resumo

Foram gerados **49 novos arquivos de áudio** em português brasileiro usando a tecnologia **Google Text-to-Speech (gTTS)**:

- **26 letras** do alfabeto (A-Z)
- **11 números** (0-10)
- **12 cores** comuns

## 📂 Localização

Todos os arquivos estão localizados em:

```bash
app/src/main/res/raw/
```

## 📝 Arquivos Gerados

### Letras do Alfabeto (26 arquivos)

| Arquivo | Conteúdo |
| --------- | ---------- |
| `letra_a.mp3` | Letra A |
| `letra_b.mp3` | Letra B |
| `letra_c.mp3` | Letra C |
| `letra_d.mp3` | Letra D |
| `letra_e.mp3` | Letra E |
| `letra_f.mp3` | Letra F |
| `letra_g.mp3` | Letra G |
| `letra_h.mp3` | Letra H |
| `letra_i.mp3` | Letra I |
| `letra_j.mp3` | Letra J |
| `letra_k.mp3` | Letra K |
| `letra_l.mp3` | Letra L |
| `letra_m.mp3` | Letra M |
| `letra_n.mp3` | Letra N |
| `letra_o.mp3` | Letra O |
| `letra_p.mp3` | Letra P |
| `letra_q.mp3` | Letra Q |
| `letra_r.mp3` | Letra R |
| `letra_s.mp3` | Letra S |
| `letra_t.mp3` | Letra T |
| `letra_u.mp3` | Letra U |
| `letra_v.mp3` | Letra V |
| `letra_w.mp3` | Letra W |
| `letra_x.mp3` | Letra X |
| `letra_y.mp3` | Letra Y |
| `letra_z.mp3` | Letra Z |

### Números (11 arquivos)

| Arquivo | Conteúdo |
| --------- | ---------- |
| `numero_0.mp3` | Zero |
| `numero_1.mp3` | Um |
| `numero_2.mp3` | Dois |
| `numero_3.mp3` | Três |
| `numero_4.mp3` | Quatro |
| `numero_5.mp3` | Cinco |
| `numero_6.mp3` | Seis |
| `numero_7.mp3` | Sete |
| `numero_8.mp3` | Oito |
| `numero_9.mp3` | Nove |
| `numero_10.mp3` | Dez |

### Cores (12 arquivos)

| Arquivo | Conteúdo |
| --------- | ---------- |
| `cor_vermelho.mp3` | Vermelho |
| `cor_azul.mp3` | Azul |
| `cor_amarelo.mp3` | Amarelo |
| `cor_verde.mp3` | Verde |
| `cor_laranja.mp3` | Laranja |
| `cor_roxo.mp3` | Roxo |
| `cor_rosa.mp3` | Rosa |
| `cor_marrom.mp3` | Marrom |
| `cor_preto.mp3` | Preto |
| `cor_branco.mp3` | Branco |
| `cor_cinza.mp3` | Cinza |
| `cor_violeta.mp3` | Violeta |

## 🔧 Como Usar no Android

### 1. Acessar os arquivos no código

```kotlin
// Exemplo: Reproduzir o áudio da letra A
val mediaPlayer = MediaPlayer.create(context, R.raw.letra_a)
mediaPlayer.start()

// Exemplo: Reproduzir o áudio do número 5
val mediaPlayer = MediaPlayer.create(context, R.raw.numero_5)
mediaPlayer.start()

// Exemplo: Reproduzir o áudio da cor azul
val mediaPlayer = MediaPlayer.create(context, R.raw.cor_azul)
mediaPlayer.start()
```

### 2. Usando com Jetpack Compose

```kotlin
@Composable
fun PlayAudioButton(audioResource: Int, label: String) {
    val context = LocalContext.current
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    
    Button(onClick = {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, audioResource).apply {
            start()
        }
    }) {
        Text(label)
    }
    
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
        }
    }
}

// Uso:
PlayAudioButton(R.raw.letra_a, "Letra A")
PlayAudioButton(R.raw.numero_5, "Número 5")
PlayAudioButton(R.raw.cor_azul, "Cor Azul")
```

### 3. Função Auxiliar para Reprodução

```kotlin
object AudioPlayer {
    private var mediaPlayer: MediaPlayer? = null
    
    fun playAudio(context: Context, audioResource: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, audioResource).apply {
            setOnCompletionListener {
                release()
                mediaPlayer = null
            }
            start()
        }
    }
    
    fun stop() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

// Uso:
AudioPlayer.playAudio(context, R.raw.letra_a)
AudioPlayer.playAudio(context, R.raw.numero_5)
AudioPlayer.playAudio(context, R.raw.cor_azul)
```

## 🛠️ Regenerar os Arquivos

Se você precisar regenerar os arquivos de áudio, use o script Python fornecido:

```bash
# Certifique-se de que a biblioteca gTTS está instalada
pip install gtts --break-system-packages

# Execute o script
python3 generate_audio_files.py
```

### Script Alternativo (Offline)

Também está disponível um script alternativo que usa `pyttsx3` para geração offline:

```bash
# Instalar pyttsx3
pip install pyttsx3 --break-system-packages

# Execute o script offline
python3 generate_audio_offline.py
```

## 📊 Especificações Técnicas

- **Formato**: MP3
- **Idioma**: Português Brasileiro (pt-br)
- **Tecnologia**: Google Text-to-Speech (gTTS)
- **Tamanho médio**: 5-10 KB por arquivo
- **Taxa de bits**: Padrão gTTS
- **Qualidade**: Adequada para aplicativos educacionais

## 📝 Notas

- Os arquivos foram gerados com voz feminina padrão do Google TTS
- A pronúncia é clara e adequada para crianças
- Os arquivos são leves e otimizados para uso em dispositivos móveis
- Todos os nomes de arquivos seguem o padrão Android (lowercase, sem caracteres especiais)

## 🔄 Arquivos Pré-existentes

O diretório também contém alguns arquivos de áudio que já existiam:

- Vogais: `vogal_a.mp3`, `vogal_e.mp3`, `vogal_i.mp3`, `vogal_o.mp3`, `vogal_u.mp3`
- Formas: `circulo.mp3`, `quadrado.mp3`, `retangulo.mp3`, `triangulo.mp3`, `estrela.mp3`
- Cores (formato antigo): `amarelo.mp3`, `azul.mp3`, `branco.mp3`, `laranja.mp3`, `marrom.mp3`, `preto.mp3`, `rosa.mp3`, `roxo.mp3`, `verde.mp3`, `vermelho.mp3`

## 📄 Licença

Os arquivos de áudio foram gerados usando a API gratuita do Google Text-to-Speech (gTTS) e podem ser usados livremente no aplicativo educacional.
