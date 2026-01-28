#!/usr/bin/env python3
"""
Script alternativo para gerar arquivos de áudio usando pyttsx3 (offline).
Não requer instalação de pacotes externos se pyttsx3 estiver disponível.

Se pyttsx3 não estiver disponível, tente:
    pip install pyttsx3 --break-system-packages

Uso:
    python generate_audio_offline.py
"""

import os
from pathlib import Path

# Tentar importar pyttsx3
try:
    import pyttsx3
    HAS_PYTTSX3 = True
except ImportError:
    HAS_PYTTSX3 = False
    print("⚠️  pyttsx3 não está instalado.")
    print("Execute: pip install pyttsx3 --break-system-packages")
    print("\nOu use o script online: python generate_audio_files.py")

# Diretório de saída para os arquivos de áudio
OUTPUT_DIR = Path("app/src/main/res/raw")

# Criar diretório se não existir
OUTPUT_DIR.mkdir(parents=True, exist_ok=True)

def generate_audio_offline(text, filename):
    """
    Gera um arquivo de áudio a partir de texto usando pyttsx3 (offline).
    
    Args:
        text: Texto a ser convertido em áudio
        filename: Nome do arquivo de saída (sem extensão)
    """
    if not HAS_PYTTSX3:
        return False
        
    try:
        engine = pyttsx3.init()
        
        # Configurar voz em português (se disponível)
        voices = engine.getProperty('voices')
        for voice in voices:
            if 'portuguese' in voice.name.lower() or 'brazil' in voice.name.lower():
                engine.setProperty('voice', voice.id)
                break
        
        # Configurar taxa de fala (um pouco mais lenta para crianças)
        engine.setProperty('rate', 150)
        
        output_path = OUTPUT_DIR / f"{filename}.mp3"
        engine.save_to_file(text, str(output_path))
        engine.runAndWait()
        
        print(f"✓ Criado: {filename}.mp3")
        return True
    except Exception as e:
        print(f"✗ Erro ao criar {filename}.mp3: {e}")
        return False

def generate_letters():
    """Gera arquivos de áudio para todas as letras do alfabeto."""
    print("\n📝 Gerando áudios das letras...")
    letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    
    for letter in letters:
        filename = f"letra_{letter.lower()}"
        generate_audio_offline(letter, filename)

def generate_numbers():
    """Gera arquivos de áudio para números de 0 a 10."""
    print("\n🔢 Gerando áudios dos números...")
    numbers = {
        0: "zero",
        1: "um",
        2: "dois",
        3: "três",
        4: "quatro",
        5: "cinco",
        6: "seis",
        7: "sete",
        8: "oito",
        9: "nove",
        10: "dez"
    }
    
    for num, text in numbers.items():
        filename = f"numero_{num}"
        generate_audio_offline(text, filename)

def generate_colors():
    """Gera arquivos de áudio para cores comuns."""
    print("\n🎨 Gerando áudios das cores...")
    colors = {
        "vermelho": "vermelho",
        "azul": "azul",
        "amarelo": "amarelo",
        "verde": "verde",
        "laranja": "laranja",
        "roxo": "roxo",
        "rosa": "rosa",
        "marrom": "marrom",
        "preto": "preto",
        "branco": "branco",
        "cinza": "cinza",
        "violeta": "violeta"
    }
    
    for color_key, color_text in colors.items():
        filename = f"cor_{color_key}"
        generate_audio_offline(color_text, filename)

def main():
    """Função principal que executa a geração de todos os áudios."""
    if not HAS_PYTTSX3:
        return
        
    print("=" * 60)
    print("🎵 Gerador de Arquivos de Áudio - Educar e Brincar (Offline)")
    print("=" * 60)
    print(f"\nDiretório de saída: {OUTPUT_DIR.absolute()}")
    
    # Gerar todos os áudios
    generate_letters()
    generate_numbers()
    generate_colors()
    
    print("\n" + "=" * 60)
    print("✅ Geração de áudios concluída!")
    print("=" * 60)
    
    # Contar arquivos gerados
    audio_files = list(OUTPUT_DIR.glob("*.mp3"))
    print(f"\nTotal de arquivos gerados: {len(audio_files)}")
    print(f"Localização: {OUTPUT_DIR.absolute()}")

if __name__ == "__main__":
    main()
